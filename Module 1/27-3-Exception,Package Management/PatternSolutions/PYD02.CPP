#include <stdio.h>
#include <conio.h>

void main()
{
	int row,colom=1,loop=0;
	clrscr();
	printf("Enter the Row for the Pyramid : ");
	scanf("%d",&row);

	while (loop <= row)
	{
		while (colom <= loop)
		{
			printf("%d",colom);
			colom++;
		}
		printf("\n");
		colom=1;
		loop++;
	}
	getch();
}

