#include <stdio.h>
#include <conio.h>

int main()
{
	int row,colom=1,loop=0;
	//clrscr();
	printf("Enter the Row for the Pyramid : ");
	scanf("%d",&row);

	while (loop <= row)
	{
		while (colom <= loop)
		{
			printf("%d ",loop*loop);
			colom++;
		}
		printf("\n");
		colom=1;
		loop++;
	}
	getch();
	return 0;
}

