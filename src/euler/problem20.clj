(ns euler.problem20)

(defn calc [n]
	(apply + (map #(- (int %) 48) (str (apply * (range 1N (inc n)))))))