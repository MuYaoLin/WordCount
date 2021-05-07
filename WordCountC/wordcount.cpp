#include <stdlib.h>
#include <stdio.h>
#include <string.h>


int main(int argc, char *argv[]) {
	FILE *f;
	char ch;
	char ch1 = ' ';
	int count = 0;
	if (argc != 3) {
		printf("请输入文件路径");
		exit(1);
	} else if (argc == 3) {
		f = fopen(argv[2], "r");
		if (f == NULL) {
			printf("文件路径%s不正确", argv[2]);
		}
		if (strcmp(argv[1], "-c") == 0) {
			while ((ch = getc(f)) != EOF) {
				count++;
			}
			printf("字符数为%d", count);
		} else {
			while ((ch = getc(f)) != EOF) {
				if ((ch >= 33 && ch <= 43) || (ch >= 45 && ch <= 126) && ((ch1 == ' ') || (ch1 == ','))) {
					count++;
				}
				ch1 = ch;
			}
			printf("单词数%d个\n", count);
		}
	}

	fclose(f);
	return 0;
}

