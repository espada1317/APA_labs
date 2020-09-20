#include <iostream>
#include <chrono>
#include <iomanip>

using namespace std;

unsigned int fib2(int n)
{
    int i = 1;
    int j = 0;

    for (int k = 0; k < n; k++)
    {
        j = i + j;
        i = j - i;
    }

    return j;
}

int main()
{
    int n = 10;

    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);

    cout << "Numarul " << n << " din sirul Fibonacci > " << fib2(n);

    auto end = chrono::high_resolution_clock::now();

    double time_taken = chrono::duration_cast<chrono::nanoseconds>(end - start).count();
    time_taken *= 1e-9;

    cout << endl << endl;
    cout << "Time taken by program is : " << fixed << setprecision(9) << time_taken;
    cout << " sec" << endl;
}
