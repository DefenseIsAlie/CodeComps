#include <iostream>
#include <vector>
#include <deque>
#include <tuple>
#include <algorithm>

using namespace std;

void DoStuff(){
}

int main(const int argc, const char **argv){
    long long t;
    cin >> t;
    for (int i = 0; i < t; i++){
        long long num_ele;
        cin >> num_ele;
        vector<long long> ele;
        for (long long i = 0; i < num_ele; i++){
            long long tmp;
            cin >> tmp;
            ele.push_back(tmp);
        }

        std::sort(ele.begin(),ele.end());

        bool ans = false;

        vector <long long> prefix_sums = {0};
		    for(int i = 0; i < num_ele; i++){
			      prefix_sums.push_back(prefix_sums.back() + ele[i]);
		    }

        vector <long long> suffix_sums = {0};
		    for(int i = num_ele - 1; i >= 0; i--){
			  suffix_sums.push_back(suffix_sums.back() + ele[i]);
		    }
	
		    for(int k = 1; k <= num_ele; k++){
			    if(2 * k + 1 <= num_ele){
				  long long blue_sum = prefix_sums[k + 1];
				  long long red_sum = suffix_sums[k];
				  if(blue_sum < red_sum){
					  ans = true;
				  }
			  }
		  }

        if (ans) cout << "YES\n";
        else cout << "NO\n";
    }
  return 0;
}
