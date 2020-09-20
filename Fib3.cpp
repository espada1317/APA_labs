#include <iostream>
#include <chrono>
#include <iomanip>

using namespace std;

unsigned int fib3(int n)
{
    int i = 1;
    int j = 0;
    int k = 0;
    int h = 1;
    int t;

    while (n > 0)
    {
        if (n % 2 == 1)
        {
            t = j * h;
            j = i * h + j * k + t;
            i = i * k + t;
        }

        t = pow(h, 2);
        h = 2 * k * h + t;
        k = pow(k, 2) + t;
        n = n / 2;
    }

    return j;
}

int main()
{
    int n = 40;

    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);

    cout << "Numarul " << n << " din sirul Fibonacci > " << fib3(n);

    auto end = chrono::high_resolution_clock::now();

    double time_taken = chrono::duration_cast<chrono::nanoseconds>(end - start).count();
    time_taken *= 1e-9;

    cout << endl << endl;
    cout << "Time taken by program is : " << fixed << setprecision(9) << time_taken;
    cout << " sec" << endl;
}
