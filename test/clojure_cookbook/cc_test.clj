(ns clojure-cookbook.cc-test
  (:require [clojure.test :refer :all]))

(deftest string-to-lower
  (testing "String to lower"
    (is (= "aabbccddeeff" (clojure.string/lower-case "AaBbCcDdEeFf")))))

(deftest trim-string
  (testing "String to lower"
    (is (= "Bacon sic dolor" (clojure.string/trim " \tBacon sic dolor \n")))))

(deftest str-function
  (testing "Look at str function"
    (is (= "1 blah 2" (str 1 " " "blah" " " 2)))))

(def food-items ["milk" "butter" "flour" "eggs"])
(def joined (clojure.string/join "," food-items))
(def split-ted (clojure.string/split joined #","))
(deftest join-split
  (testing "Join and then split" (is (= food-items split-ted))))
