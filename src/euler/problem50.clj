(ns euler.problem50)

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
(defn sum-count [d t]
   (last
      (take t 
         (map #(list %1 %2) 
            (reductions + (drop d (lazy-primes))) 
            (reductions + (repeat 1))))))

(defn max-sum-count [[sum1 cnt1 :as a]  [sum2 cnt2 :as b] ]
   ( if( > cnt1 cnt2) a b))

(defn list-of-ranges [n] 
   (let [max-summands (count (take-while #(< % n) (reductions + (lazy-primes))))]
      (for [ d (range (dec max-summands)) t (range 2 (inc max-summands)) :when (<= d (- max-summands t))]
         (list d t))))

(defn max-sum [n]
   (loop [[f & r] (list-of-ranges n) acc [0 0]]
      (if (nil? f) acc 
         (if (>= (last acc) (last f)) (recur r acc)
            (let [x (sum-count (first f) (last f))]
               (if (prime? (first x)) 
                  (recur r (max-sum-count acc x))	
                  (recur r acc)))))))

(defn calc [n]
  (first (max-sum n)))