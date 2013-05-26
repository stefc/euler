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

; kleinster gemeinsamer Vielfacher 
(defn no5 [n] 
	(letfn [
		(multiplier [n] (iterate (partial + n) n))
		(kgv [a b]
			(letfn [(f [a b]
	 			(if(= (first a) (first b)) (first a)
	 				(if(> (first a) (first b))
	 					(recur a (rest b)) (recur (rest a) b))))]
			(f (multiplier a) (multiplier b))))]
	(reduce kgv (range 1 (inc n)))))

(defn -main [& args]
 	(time(println (format "Problem No %d = %d" 1 (no1 1e3))))
 	(time(println (format "Problem No %d = %d" 2 (no2 4e6))))
 	(time(println (format "Problem No %d = %d" 3 (no3 600851475143))))
 	(time(println (format "Problem No %d = %d" 5 (no5 10))))
  )
