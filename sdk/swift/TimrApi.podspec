Pod::Spec.new do |s|
  s.name = 'TimrApi'
  s.ios.deployment_target = '11.0'
  s.osx.deployment_target = '10.13'
  s.tvos.deployment_target = '11.0'
  s.watchos.deployment_target = '4.0'
  s.swift_version = '5.5'
  s.version = '1.0.0'
  s.source = { :git => 'https://github.com/troii/timr-api-swift.git', :tag => s.version.to_s }
  s.authors = 'troii Software GmbH'
  s.license = 'Apache-2.0'
  s.homepage = 'https://developer.timr.com'
  s.summary = 'Official Swift client for the timr API'
  s.description = 'Official Swift client for the timr API, generated from its OpenAPI specification.'
  s.documentation_url = 'https://developer.timr.com'
  s.source_files = 'TimrApi/**/*.swift'
  s.dependency 'AnyCodable-FlightSchool', '~> 0.6'
  s.dependency 'Alamofire', '~> 5.7'
end
