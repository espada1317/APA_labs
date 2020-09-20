#include <iostream>
#include <chrono>
#include <iomanip>

using namespace std;

unsigned int fibonacci_recursion(int n)
{
    if (n < 2)
        return n;
    else
        return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
}

int main()
{
    int n = 40;

    auto start = chrono::high_resolution_clock::now();
    ios_base::sync_with_stdio(false);

    cout << "Numarul " << n << " din sirul Fibonacci > " << fibonacci_recursion(n);
    
    auto end = chrono::high_resolution_clock::now();
    double time_taken = chrono::duration_cast<chrono::nanoseconds>(end - start).count();
    time_taken *= 1e-9;

    cout << endl << endl;
    cout << "Time taken by program is : " << fixed << setprecision(9) << time_taken;
    cout << " sec" << endl;
}
