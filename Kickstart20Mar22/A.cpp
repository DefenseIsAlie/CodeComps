#include <iostream>
#include <string>

using namespace std;

bool checkIfsubsequence(string I, string P, int i, int p){
	if (i==0){
		return true;
	}
	if (p == 0){
		return false;
	}

	if (I[i-1] == P[p-1]){
		return checkIfsubsequence(I, P,  i-1,  p -1);
	}

	return checkIfsubsequence(I,  P,  i,  p-1);
}

int main(){
	int t = 0;
	cin >> t;

	for(int i = 0; i < t; i++){
		string I;
		string P;
		
		cin >> I;
		cin >> P;

		long long inp_len = P.length();
		long long correct_len = I.length();
		if (I == P){
			cout << "Case #" << i << ": 0" << "\n";
			continue;
		}

		if (inp_len <= correct_len){
			cout << "Case #" << i << ": IMPOSSIBLE" << "\n";
			continue;
		}

		long long ans = inp_len - correct_len;
		bool canbedone = checkIfsubsequence( I,  P, I.length(), P.length());


		if (canbedone) {
			cout << "Case #" << i << ": "<< ans << "\n";
		}
		else {cout << "Case #" << i << ": IMPOSSIBLE" << "\n" ;
		}
	}
	return 0;
}
