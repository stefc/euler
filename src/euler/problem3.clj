(ns euler.problem3)

; größte Primzahl
;
(defn calc [n]
	(let [max (int (Math/sqrt n))]
		(loop [x n acc 2]
			(cond 
				(or(> acc max) (= x acc))	x
				(zero? (rem x acc))			(recur (/ x acc) acc)
				:else						(recur x (inc acc))))))