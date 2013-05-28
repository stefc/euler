(ns euler.problem7)

(defn calc [n]
	(let [
		wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6 4 2 6 4 6 8 4 2 4 2 4 8 6 4 6 2 4 6 2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])
		next-prime (fn next-prime [x xs [f & r]]
			(if (some #(zero? (rem x %)) (take-while #(<= (* % %) x) xs))
				(recur (+ x f) xs r)
				(cons x (lazy-seq (next-prime (+ x f) (conj xs x) r)))))]
	(first 
		(drop (dec n) 
			(concat [2 3 5 7] (lazy-seq (next-prime 11 [] wheel)))))))