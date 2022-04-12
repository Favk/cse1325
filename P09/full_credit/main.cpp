#include <iostream>
#include "color.h"

int main(){
	int red = 0;
	int green = 0;
	int blue = 0;

	Color utBlue {0, 100, 177};

	std::cout << utBlue.colorize("UTA BLUE") << std::endl;

	std::cout << "Enter red, green and blue colors: ";
	std::cin >> red >> green >> blue;

	Color color {red, green, blue};
	std::cout << color.colorize(color.to_string()) << std::endl;

	return 0;
}