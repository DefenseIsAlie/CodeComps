#pragma once
#include <iostream>
#include <vector>
#include <fstream>
#include <tuple>

int v = 0;
int e = 0;



class Vertex{
    public:
        int index;
        std::vector<std::pair<int,float>> AdjList;
};

class Edges{
    public:
        std::tuple<int,int,float> edg;
};


class Graph{
    private:
        std::vector<Vertex> AdjList;
        std::vector<Edges> E;
    public:
        void MakeGraph(std::vector<Vertex> &VerList, std::vector<Edges> &EdgList){
            for (int i = 0; i < EdgList.size(); i++){
                auto u = std::get<0>(EdgList[i].edg);
                VerList[u].index = u;
                auto v = std::get<1>(EdgList[i].edg);
                auto w = std::get<2>(EdgList[i].edg);
                std::pair<int,float> tmp;
                tmp.first = v;
                tmp.second = w;
                VerList[u].AdjList.push_back(tmp);
            }

            for (int i = 0; i < EdgList.size(); i++){
                auto u = std::get<1>(EdgList[i].edg);
                VerList[u].index = u;
                auto v = std::get<0>(EdgList[i].edg);
                auto w = std::get<2>(EdgList[i].edg);
                std::pair<int,float> tmp;
                tmp.first = v;
                tmp.second = w;
                VerList[u].AdjList.push_back(tmp);
            }
        }

        Graph(std::vector<Edges> &List){
            std::cout << "Graph constructor called" << std::endl;
            this->E  = List;
            MakeGraph(this->AdjList, List);
            std::cout << "Graph constructed" << std::endl;
        }

        ~Graph(){
            std::cout << "Graph destructed" << std::endl;
        }
};



std::vector<Graph> G;

void ParseInput(const std::ifstream &File, std::vector<Edges> &vec);
