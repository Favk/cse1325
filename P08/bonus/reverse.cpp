#include <string>
#include <iostream>
using namespace std;

string convertToString(char* a){
    string s = a;
    return s;
}

void reverseString(string& str){
	int size = str.length();

	for(int i = 0; i < (size / 2); i++){
		swap(str[i], str[size-i-1]);
	}
}

int main(int argc, char** argv){

	for (int i = 1; i < argc; ++i){
		cout << convertToString(argv[i]) << endl;
	}
	return 0;
}