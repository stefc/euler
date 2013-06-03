(ns euler.problem12)

(def triangles (map first (iterate (fn [[a b]] [(+ a b) (inc b)]) [1 2])))

(defn prime? [n]
   (if (< n 2) false
   		(loop [x n acc 2]
      		(cond 
         		(= x acc) true
         		(zero? (rem x acc)) false
         		:else (recur x (inc acc))))))


(defn primes [n]
	(let [max (int (Math/sqrt n))]
		(loop [x n p 2 acc '(2)]
			(cond 
				(>= x max)  	
				(zero? (rem x acc))			(recur (/ x p) p acc) ; Teilbar
				:else						(recur x (inc p) (cons x acc))))))	 ; Prime

(defn count-factors [n]
	(loop [x 1 acc 0]
		(if (> x n) 	acc 
			(recur (inc x) (if (zero? (rem n x)) (inc acc) acc )))))

(defn calc [n] 
	(first (filter #(> (count-factors %) n) triangles)))	

   (apply + (take-while #(< % n) (filter even? (map first (iterate (fn [[a b]] [b (+ a b)]) [1 2]))))))