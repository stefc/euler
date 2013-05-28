(ns euler.problem10)

(defn lazy-primes []
    (let [next-prime
        (fn next-prime [x xs] 
          (if (some #(zero? (rem x %)) (take-while #(<= (* % %) x) xs))
              (recur (+ x 2) xs)
              (cons x (lazy-seq (next-prime (+ x 2) (conj xs x))))))]
            (cons 2 (lazy-seq (next-prime 3 [])))))

(defn calc [n]
	(apply + (take-while #(< % n) (lazy-primes))))