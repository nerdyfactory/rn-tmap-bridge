// RNTMapManager.m
#import "TMapView.h"
#import "TMapPoint.h"
#import <React/RCTLog.h>
#import <React/RCTViewManager.h>

@interface RNTMapManager : RCTViewManager
@property (readwrite, nonnull) TMapView* _mapView;
@end

@implementation RNTMapManager

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

- (id) init {
  self = [super init];
  if (self) {
    self._mapView = [[TMapView alloc] init];
  }
  return self;
}

RCT_EXPORT_MODULE(RNTMap)

RCT_EXPORT_METHOD(setApiKey:(NSString *)key)
{
  [self._mapView setSKTMapApiKey:key];
}

RCT_EXPORT_METHOD(setHttpsMode:(BOOL)isActive)
{
  [self._mapView setHttpsMode:isActive];
}

RCT_EXPORT_METHOD(setCoordinates:(double)lat lng:(double)lng)
{
  NSNumber *myDoubleNumber = [NSNumber numberWithDouble:lat];
  NSString *latitude = [myDoubleNumber stringValue];
  RCTLogInfo(latitude);
  [self._mapView setLocationPoint:[TMapPoint mapPointWithCoordinate:CLLocationCoordinate2DMake(lat, lng)]];
}

- (UIView *)view
{
  [self._mapView setAutoresizingMask:UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight];
  [self._mapView setDelegate:self];
  [self._mapView setGpsManagersDelegate:self];
  return [self._mapView init];
}

@end
