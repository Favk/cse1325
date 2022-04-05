#include <string>
#include <iostream>
#include <algorithm>
using namespace std;

void Reverse(char arr[]){
	if (*arr == '\0'){
		return;
	}
	else{
		Reverse(arr+1);
		cout << *(arr);
	}
}

int main(int argc, char** argv){
	for (int i = 1; i < argc; ++i){
		Reverse(argv[i]);
		cout << endl;
	}
	return 0;
}