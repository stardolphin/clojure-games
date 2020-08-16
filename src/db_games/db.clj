(ns db-games.db)
(require '[clojure.java.jdbc :as jdbc])


(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname "//localhost:5432/clojure_test"
              :user "michael"
              :password "michael"})

(defn insert-employee [name email age]
  (jdbc/insert! db-spec
                :employees
                {:name name :email email :age age}))

;; suppress errors
(if insert-employee (do))
