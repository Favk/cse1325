#include "color.h"
#include <sstream>

Color::Color(int red, int green, int blue)
			: _red{red}, _green{green}, _blue{blue} {}

std::string Color::to_string(){
	std::ostringstream colors;
	colors << "(" << _red << "," << _green << "," << _blue << ")";
	return colors.str();
}

std::string Color::colorize(std::string text){
	return "\033[38;2;" + std::to_string(_red) + ";" + std::to_string(_green) + ";" + std::to_string(_blue) + "m"
			+ text + "\033[0m";
}