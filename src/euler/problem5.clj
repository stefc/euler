(ns euler.problem5)

; kleinster gemeinsamer Vielfacher  
(defn calc [n]
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
