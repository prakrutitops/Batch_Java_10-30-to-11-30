//...Center Allign Reverse * Pyramid...
#include <stdio.h>
#include <conio.h>

void main()
{
	int row,colom,space,loop;
	clrscr();

	printf("Enter the Row for the Pyramid : ");
	scanf("%d",&row);

	for (loop=row;loop>=1;loop--)
	{
		for (space=1;space<row-loop+1;space++)
			printf(" ");

		for (colom=1; colom <= loop; colom++)
			printf("* ");

		printf("\n");
	}
	getch();
}
