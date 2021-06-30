#include <stdio.h>
#include <stdint.h>
#include <linux/input.h>
#include <string.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

#define test_bit(bit, array)    (array[bit/8] & (1<<(bit%8)))


void printEveryAxis(int fd, uint8_t* abs_bitmask);
void setBitmask(int fd, uint8_t* abs_bitmask, int bitmaskSize);
int getFD(char* name);
void checkArgs(int argc);

int main(int argc, char** argv) {
    checkArgs(argc);
    int fd = getFD(argv[1]);

    uint8_t abs_bitmask[ABS_MAX/8 + 1];
    setBitmask(fd, abs_bitmask, ABS_MAX/8 + 1);

    printEveryAxis(fd, abs_bitmask);
    close(fd);
    return 0;
}

void setBitmask(int fd, uint8_t* abs_bitmask, int bitmaskSize) {
    memset(abs_bitmask, 0, bitmaskSize);
    if (ioctl(fd, EVIOCGBIT(EV_ABS, bitmaskSize), abs_bitmask) < 0) {
        perror("Could not read available axis");
        close(fd);
        exit(1);
    }
}

int getFD(char* name) {
    int fd = open(name, O_RDONLY);
    if(fd < 0) {
        perror("Could not open file");
        return 1;
    }
    return fd;
}

void checkArgs(int argc){
    if(argc < 1) {
        perror("No event file provided");
        exit(1);
    }
}

void printEveryAxis(int fd, uint8_t* abs_bitmask) {
    for(int axisindex = 0; axisindex < ABS_MAX; ++axisindex) {
        struct input_absinfo abs_features;

        if(ioctl(fd, EVIOCGABS(axisindex), &abs_features) || test_bit(axisindex, abs_bitmask)) {
            printf("%d, %d, %d, %d, %d, %d, %d\n",
            axisindex,
            abs_features.value, abs_features.minimum, abs_features.maximum,
            abs_features.flat, abs_features.fuzz, abs_features.resolution);
        }
    }
}
