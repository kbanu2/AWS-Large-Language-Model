cmake_minimum_required(VERSION 3.23)
project(Controller)

set(CMAKE_CXX_STANDARD 14)

# Set the path for OmniORB includes
include_directories(/opt/homebrew/opt/omniorb/include)
include_directories(/opt/homebrew/Cellar/omniorb/4.3.2/include)

# Set the path for OmniORB libraries
link_directories(/opt/homebrew/opt/omniorb/lib)
link_directories(/usr/local/lib)

# Add the executable for your Controller
add_executable(Controller
    Controller.cpp
    FileProcessorImpl.cpp
        TextProcessingSK.cc
)

# Link against OmniORB libraries
target_link_libraries(Controller omniORB4 omnithread)
