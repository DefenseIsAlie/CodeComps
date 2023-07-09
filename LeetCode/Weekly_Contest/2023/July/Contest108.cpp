#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

/* 

n ≤ 10
n ≤ 20
n ≤ 500
n ≤ 5000
n ≤ 106
n is large

O (n!)
O (2n )
O (n3 )
O (n2 )
O (n log n) or O( n )
O (1) or O(log n)
*/

class Solution {
public:
    int alternatingSubarray(vector<int>& nums) {
        int max_len = 0;
        for (int m = 0; m < nums.size() ; m++){
            for (int j = m+1; j <= nums.size(); j++){
                if (check_subarray(m, j, nums))
                {
                    max_len = max(max_len, j-m);
                }
                
            }
        }
        
        return max_len+1;
    }

    bool check_subarray(int left, int right, vector<int>& nums){
        bool ret = true;
        int sub_indx = 0;
        for (int i = left+1; i <= right; i++)
        {
            if ((nums[i-1] - nums[i-2])!=(int)pow(-1, sub_indx))
            {
                ret = false;
            }
            sub_indx++;
        }
        return ret;
    }
};

int main(int argc, char *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);

    // int t;
    // cin >> t;

    // for (int i = 0; i < t; i++)
    // {
    // }

    Solution t;

    vector<int> test = {2,3,4,3,4};
    cout << t.alternatingSubarray(test) << "\n";
}


