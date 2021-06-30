#include <stdio.h>
#include <linux/input.h>

int main() {
    struct input_event i;

    printf("%d \n", sizeof(i));
    printf("%d \n", sizeof(i.time.tv_sec));
    printf("%d \n", sizeof(i.time.tv_usec));
    printf("%d \n", sizeof(i.type));
    printf("%d \n", sizeof(i.code));
    printf("%d \n", sizeof(i.value));
}
