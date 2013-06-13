(ns euler.problem40)

(defn log10 [n]
	(int (+ 0.00000001 (/ (Math/log n) (Math/log 10)))))

(defn pow10 [n] 
	(apply * (repeat n 10)))

(defn to-digits 
	(
		[n start]
			(map (fn [[a b]] (int(/ b a))) 
				(take-while (fn [[a b]] (>= a 1)) 
					(iterate (fn [[a b]] [(/ a 10) (- b (* a (int (/ b a))))]) [start n]))))
	(	[n] 
			(to-digits n (pow10 (log10 n)))))

(defn tuple-seq [n] 
	(take n (map #(list %1 (log10 %2)) (flatten (map to-digits (iterate inc 1))) (iterate inc 1) )))

(apply * (map first (map first (partition-by #(last %) (tuple-seq 1e6)) )))

