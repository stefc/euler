(ns euler.problem16)

(defn calc [n]
	(apply + (map #(- (int %) 48) (str (apply * (repeat n 2N))))))
