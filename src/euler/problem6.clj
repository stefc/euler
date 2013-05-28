(ns euler.problem6)

(defn calc [n]
	(letfn [ (square [x] (* x x))]
    	(- (square (apply + (range 1 (inc n)))) (apply + (map square (range 1 (inc n)))))))