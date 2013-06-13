(defn pow [b e] 
	(apply * (repeat e b)))

(apply + (map #(pow % %) (range 1N 11N)))
