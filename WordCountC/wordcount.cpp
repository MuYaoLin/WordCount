#include <stdlib.h>
#include <stdio.h>
#include <string.h>


int main(int argc, char *argv[]) {
	FILE *f;
	char ch;
	char ch1 = ' ';
	int count = 0;
	if (argc != 3) {
		printf("�������ļ�·��");
		exit(1);
	} else if (argc == 3) {
		f = fopen(argv[2], "r");
		if (f == NULL) {
			printf("�ļ�·��%s����ȷ", argv[2]);
		}
		if (strcmp(argv[1], "-c") == 0) {
			while ((ch = getc(f)) != EOF) {
				count++;
			}
			printf("�ַ���Ϊ%d", count);
		} else {
			while ((ch = getc(f)) != EOF) {
				if ((ch >= 33 && ch <= 43) || (ch >= 45 && ch <= 126) && ((ch1 == ' ') || (ch1 == ','))) {
					count++;
				}
				ch1 = ch;
			}
			printf("������%d��\n", count);
		}
	}

	fclose(f);
	return 0;
}

