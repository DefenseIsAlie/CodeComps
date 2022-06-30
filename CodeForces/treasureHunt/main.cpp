#include <iostream>
#include "libs/Graph.hpp"

int main(const int argc, const char **argv) {
    std::ifstream Input(argv[1]);
    if (Input.is_open()){

    }else{
        std::cerr << "Failed to open" << argv[1]  << std::endl;
    }
    return 0;
}
