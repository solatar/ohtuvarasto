A self-organizing map (SOM) or self-organizing feature map (SOFM) is an unsupervised machine learning technique used to produce a low-dimensional
(typically two-dimensional) representation of a higher dimensional data set while preserving the topological structure of the data. For example, a data set with
p {\displaystyle p} p variables measured in n {\displaystyle n} n observations could be represented as clusters of observations with similar values for the variables.
These clusters then could be visualized as a two-dimensional "map" such that observations in proximal clusters have more similar values than observations in distal
clusters. This can make high-dimensional data easier to visualize and analyze.

An SOM is a type of artificial neural network but is trained using competitive learning rather than the error-correction learning (e.g., backpropagation with gradient
descent) used by other artificial neural networks. The SOM was introduced by the Finnish professor Teuvo Kohonen in the 1980s and therefore is sometimes called a Kohonen
map or Kohonen network. The Kohonen map or network is a computationally convenient abstraction building on biological models of neural systems from the 1970s and
morphogenesis models dating back to Alan Turing in the 1950s.

Self-organizing maps, like most artificial neural networks, operate in two modes: training and mapping. First, training uses an input data set (the "input space")
to generate a lower-dimensional representation of the input data (the "map space"). Second, mapping classifies additional input data using the generated map.

In most cases, the goal of training is to represent an input space with p dimensions as a map space with two dimensions. Specifically, an input space with p variables
is said to have p dimensions. A map space consists of components called "nodes" or "neurons," which are arranged as a hexagonal or rectangular grid with two dimensions.
The number of nodes and their arrangement are specified beforehand based on the larger goals of the analysis and exploration of the data.

Each node in the map space is associated with a "weight" vector, which is the position of the node in the input space. While nodes in the map space stay fixed, training
consists in moving weight vectors toward the input data (reducing a distance metric such as Euclidean distance) without spoiling the topology induced from the map space.
After training, the map can be used to classify additional observations for the input space by finding the node with the closest weight vector (smallest distance metric)
to the input space vector.
