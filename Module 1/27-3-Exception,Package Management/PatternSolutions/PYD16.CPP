//...Center Allign Reverse * Pyramid...
#include <stdio.h>
#include <conio.h>

void main()
{
	int row,colom,space,loop;
	clrscr();

	printf("Enter the Row for the Pyramid : ");
	scanf("%d",&row);

		for (loop=1;loop <=row;loop++)
	{
		for (space=0;space<row-loop+2;space++)
			printf(" ");

		for (colom=1; colom <= loop; colom++)
			printf("* ");

		printf("\n");
	}

	for (loop=row;loop>=1;loop--)
	{
		for (space=0;space<row-loop+2;space++)
			printf(" ");

		for (colom=1; colom <= loop; colom++)
			printf("* ");

		printf("\n");
	}

	getch();
}
