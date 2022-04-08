#ifndef _COLOR_H
#define _COLOR_H

#include "color.h"
#include <string>

class Color{
	private:
		int _red = 0;
		int _blue = 0;
		int _green = 0;

	public:
		Color(int red, int green, int blue);
		std::string to_string();
		std::string colorize(std::string text);
};

#endif