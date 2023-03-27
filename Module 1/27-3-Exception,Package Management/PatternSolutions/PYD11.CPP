#include <stdio.h>
#include <conio.h>

void main()
{
	int row,colom=1,loop=0,binary=1;
	clrscr();
	printf("Enter the Row for the Pyramid : ");
	scanf("%d",&row);

	while (loop <= row)
	{
		while (colom <= loop)
		{
			printf("%d ",binary);
			colom++;
			if (binary == 1)
			{
				binary = 0;
			}
			else
			{
				binary = 1;
			}
		}
		printf("\n");
		colom=1;
		loop++;
	}
	getch();
}

