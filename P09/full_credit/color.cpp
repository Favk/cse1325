#include "color.h"

Color::Color(int red, int green, int blue)
			: _red{red}, _green{green}, _blue{blue} {}

std::string Color::to_string(){
	return "Color(_red, _green, _blue)";
}

std::string Color::colorize(std::string text){
	return text;
}