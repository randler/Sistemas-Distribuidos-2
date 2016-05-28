#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main(){
	int i;
	//pid_t esta contido na biblioteca <sys/types.h>
	pid_t pid;

	if((pid = fork()) <0){
		perror("fork");
		exit(1);
	}
	if(pid == 0 ){
		printf(" pid do Filho: %d\n", getpid());
		}else{
			printf(" pid do Pai: %d\n", getpid());
		}

		printf("Essa instrução vai ser executada por todos Anteriores:");

		scanf("%d", &i);
		exit(0);

	return 0;
}
