(ns euler.problem25)

(defn fib [a b] (cons a (lazy-seq (fib b (+ b a)))))

(defn find-first [f coll]
	(first (filter f coll)))

(defn indexed-fib [] 
	(map #(list %1 %2) (fib 1N 1N) (iterate inc 1N)))

(defn pow [n] 
	(apply * (take n (repeat 10N))))

(next(find-first #(>= (first %) (pow (dec 1000))) (indexed-fib)))