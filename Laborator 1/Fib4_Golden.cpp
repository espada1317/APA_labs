#include <iostream>
#include <chrono>
#include <iomanip>

using namespace std;

unsigned int fib4_golden(int n)
{
    double fi = (1 + sqrt(5)) / 2;
    return  ( pow(fi, n) - pow(-fi, -n) )/( 2 * fi - 1);
}

int main()
{
    int n = 40;

    auto start = chrono::high_resolution_clock::now();

    cout << "Numarul " << n << " din sirul Fibonacci > " << fib4_golden(n);

    auto end = chrono::high_resolution_clock::now();

    double time_taken = chrono::duration_cast<chrono::microseconds>(end - start).count();
    time_taken *= 1e-6;

    cout << endl << endl;
    cout << "Time taken by program is : " << fixed << setprecision(5) << time_taken;
    cout << " sec" << endl;
}
