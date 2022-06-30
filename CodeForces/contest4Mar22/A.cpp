#include <cmath>
#include <iostream>

int main(){
    long t=0;
    std::cin >> t;

    for (long i = t; i>0; i--){
        long long n ,s ;
        std::cin >> n >> s;
        std::cout << s / (n*n) << "\n";
    }

}
