(ns euler.core
  (:gen-class))

; Multiples of 3 and 5
; 
; Multiplier bestimmen
; Filter Funktion
; Reduce zum Aufsummieren
;
(defn no1 [n] ; 6.3 msec
	(apply + (filter #(or 
			(zero? (rem % 5))
			(zero? (rem % 3)))
		(range n))))

; Smarter but very slow ?
;(defn no1 [n]
;	(letfn [(where [x] ( eval (cons 'or (map (fn [y] (zero? (mod x y))) '(3 5)))))  ]	
;   		(apply + (filter where (range n)))))

; Even Fibonacci numbers

; Lazy-Seq / take-while / filter / even-numbers

;(defn no2 [n] ; 1.5 msec
;	(letfn [(fib [a b] (cons a (lazy-seq (fib b (+ b a)))))]
;		(apply + (take-while (fn [x] (< x n)) (filter even? (fib 1 2))))))

(defn no2 [n] 
   (apply + (take-while #(< % n) (filter even? (map first (iterate (fn [[a b]] [b (+ a b)]) [1 2]))))))

; größte Primzahl
;
(defn no3 [n]
	(let [max (int (Math/sqrt n))]
		(loop [x n acc 2]
			(cond 
				(or(> acc max) (= x acc))	x
				(zero? (rem x acc))			(recur (/ x acc) acc)
				:else						(recur x (inc acc))))))





; (for [x (reverse(range 99 999)) y (reverse(range 99 999 11))] [x y]))

(defn no4 [n] 
	(letfn [
		(pow10 [e] (int(Math/pow 10 e)))
		(palindrom? [vec] (= vec (reverse vec)))
		(split [n digits] 
			(loop [v n idx digits acc []]
				(let [weight (pow10 (dec idx))]
					(if(zero? idx) acc 
						(recur (- v (* weight (int(/ v weight)) )) (dec idx) (conj acc (int(/ v  weight))))))))	
		(products [n] 
			(filter #(palindrom? (split % n)) 
				(for [a (range 99 999) b (range 99 999 11)] (* a b))))
		](apply max (products (+ n n)))))

; kleinster gemeinsamer Vielfacher  
(defn no5 [n]
	(letfn [
		(divable? [a b] (zero? (rem a b)))
		(pow [b e] (int(Math/pow b e)))
		(max-aggregate [a b] (map max a b))
		(count-div [n factor]
			(loop [x n accu 0]
				(if (divable? x factor) (recur (/ x factor) (inc accu)) accu)))]
	(let [
		primes '(2 3 5 7 11 13 17 19)
		primeFactors (fn [n]
			(loop [p primes accu []]
				(if	(empty? p) accu
					(recur (rest p) (conj accu (if(divable? n (first p)) (count-div n (first p)) 0))))))
		exponents (reduce max-aggregate (map primeFactors (range 2 (inc n))))]	
	(apply * (map pow primes exponents)))))

(defn -main [& args]
 	(time(println (format "Problem No %d = %d" 1 (no1 1e3))))
 	(time(println (format "Problem No %d = %d" 2 (no2 4e6))))
 	(time(println (format "Problem No %d = %d" 3 (no3 600851475143))))
 	(time(println (format "Problem No %d = %d" 4 (no4 3))))
 	(time(println (format "Problem No %d = %d" 5 (no5 20))))
  )
