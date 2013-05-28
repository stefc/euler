(ns euler.problem37)

(defn pow10 [e] (int(Math/pow 10 e)))

(defn trunc [n f] 
   (loop [e 1 acc '()]
      (if (>= (pow10 e) n) acc
         (recur (inc e) (cons (f n (pow10 e)) acc)))))

(defn trunc-rtl [n] 
   (trunc n #(int (/ %1 %2))))	

(defn trunc-ltr [n] 
   (trunc n rem))	

(defn truncate [n]
   (distinct (concat (trunc-rtl n) (trunc-ltr n))))

(defn lazy-primes []
    (let [next-prime
        (fn next-prime [x xs] 
          (if (some #(zero? (rem x %)) (take-while #(<= (* % %) x) xs))
              (recur (+ x 2) xs)
              (cons x (lazy-seq (next-prime (+ x 2) (conj xs x))))))]
            (cons 2 (lazy-seq (next-prime 3 [])))))

(defn prime? [n]
   (if (< n 2) false
   		(loop [x n acc 2]
      		(cond 
         		(= x acc) true
         		(zero? (rem x acc)) false
         		:else (recur x (inc acc))))))

(defn all-truncs-are-primes? [n]
   (every? prime? (truncate n)))	

(defn calc [n]
	(apply + (take n (filter all-truncs-are-primes? (drop 4 (lazy-primes))))))