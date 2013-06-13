(ns euler.problem35)

(defn log10 [n]
	(int (+ 0.00000001 (/ (Math/log n) (Math/log 10)))))

(defn pow10 [n] 
	(apply * (repeat n 10)))

(defn lazy-primes []
    (let [next-prime
        (fn next-prime [x xs] 
          (if (some #(zero? (rem x %)) (take-while #(<= (* % %) x) xs))
              (recur (+ x 2) xs)
              (cons x (lazy-seq (next-prime (+ x 2) (conj xs x))))))]
            (cons 2 (lazy-seq (next-prime 3 [])))))

(defn prime? [n]
      (.isProbablePrime (BigInteger/valueOf n) 5))

(defn int-to-digits 
	(
		[n start]
			(map (fn [[a b]] (int(/ b a))) 
				(take-while (fn [[a b]] (>= a 1)) 
					(iterate (fn [[a b]] [(/ a 10) (- b (* a (int (/ b a))))]) [start n]))))
	(	[n] 
			(int-to-digits n (pow10 (log10 n)))))

(defn digits-to-int [digits]
	(reduce #(+ (* %1 10) %2)  digits))

(defn permutate [n]
	(let [digits (inc (log10 n))]
		(for [x (range digits)] (digits-to-int (take digits (drop x (cycle (int-to-digits n))))))))

(defn circular-prime? [n]
	(every? prime? (permutate n)))

(defn count-circular-primes [n]
	(count (filter circular-prime? (take-while #(< % n) (lazy-primes)))))

