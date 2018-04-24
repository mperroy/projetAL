package shapeFactory;

import shapes.RegularPolygonSimple;

public class FXRegularPolygon extends RegularPolygonSimple {
	// draw lines in a group (?) to match the polygon requested
	
	/* Formula using starting coordinates, angle (((n-2)*180)/n) and edge length, draw line between points and repeat
	startX = x;
	startY = y;
	endX   = x + 40 * Math.sin(angle);
	endY   = y + 40 * Math.cos(angle);

	And draw a line from (startX, startY) to (endX, endY) in whatever API you're using.

	Also note that angle is in radians. If you had it in degrees, you need to convert it first:

	angle = angle * Math.PI / 180;
	*/
}