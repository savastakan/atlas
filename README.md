# ATLAS; new heuristic algorithm for traversing all edges with minimum cost

Traversing all edges with minimum cost at graph, is widely used in software testing area. Either the algorithms proposed in relation to this today, have high complexities or their success rate is low. Chinese Postman Problem (CPP), H-Switch-Cover (HSC), Breath First Search (BFS), Depth First Search (DFS) algorithms can be shown as examples for these. BFS and DFS algorithms produce very long and high number of test cases. On the other hand, in HSC algorithm, it is first required for graph to be transformed into balance form. This causes for complexity to increase. CPP algorithm has similar problems. Highness of complexity causes for problems in FSMs. For this reason it bears importance to develop algorithms having low complexities. In this study, a new method called ATLAS is proposed, in which the graph is processed without going through any pre-process and obtained by using dynamic programming. Our method is compared with DFS, BFS, CPP and HSC algorithms in terms of test case size, total test suite size, fault detection ratio, killed mutant per test case, killed mutant per transition and runtime. Runtime of method we propose is lower with respect to other methods. Its success show similarity with CPP algorithm. 
