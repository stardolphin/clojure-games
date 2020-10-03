(defproject spreadsheet-games "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [dk.ative/docjure "1.14.0"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [org.postgresql/postgresql "42.2.14"]
                 [talltale "0.4.3"]
                 [inflections "0.13.2"]
                 ]
  :main ^:skip-aot spreadsheet-games.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
