cmake_minimum_required(VERSION 3.23)
project(Controller)

set(CMAKE_CXX_STANDARD 14)
include_directories(/opt/homebrew/opt/omniorb)
include_directories(/opt/homebrew/Cellar/omniorb/4.3.2/include)
link_directories(/usr/local/lib)
add_executable(Controller Controller.cpp)
target_link_libraries(Controller omniORB4 omnithread)
