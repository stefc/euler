(ns euler.problem12)

(defn triangels []
	(reductions + (iterate inc 1)))

(defn number-of-divisors [number]
	(let [sqrt (int (Math/sqrt number))]
		(loop [i 1 nod 0]
			(cond
				(> i sqrt) (if (= (* sqrt sqrt) number) (dec nod) nod)
				(zero? (mod number i)) (recur (inc i) (+ nod 2))
				:else (recur (inc i) nod)))))

(defn calc [n] 
	(first (drop-while #(< (number-of-divisors %) n) (triangels))))