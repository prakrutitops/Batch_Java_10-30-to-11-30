#include <stdio.h>
#include <conio.h>

void main()
{
	int row,colom=0,loop=0;
	clrscr();
	printf("Enter the Row for the Pyramid : ");
	scanf("%d",&row);

	while (loop <= row)
	{
		while (colom < loop)
		{
			printf("*");
			colom++;
		}
		printf("\n");
		colom=0;
		loop++;
	}

	loop=loop-2;
	getch();
}

