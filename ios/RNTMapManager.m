// RNTMapManager.m
#import "TMapView.h"
#import <React/RCTLog.h>
#import <React/RCTViewManager.h>

@interface RNTMapManager : RCTViewManager
@property (readwrite, nonnull) TMapView* _mapView;
@property (retain, nonatomic) IBOutlet UIView *mapContainerView;
@property (retain, nonatomic) IBOutlet UIView *menuView;
@end

@implementation RNTMapManager


static TMapGpsManager *__gps = nil;

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

RCT_EXPORT_METHOD(setIcon:(UIImage *)icon)
{
  [self._mapView setIcon:icon];
}

RCT_EXPORT_METHOD(showIcon:(BOOL)visible)
{
  [self._mapView setIconVisibility:visible];
}

RCT_EXPORT_METHOD(zoomIn)
{
  [self._mapView zoomIn];
}

RCT_EXPORT_METHOD(zoomOut)
{
  [self._mapView zoomOut];
}

RCT_EXPORT_METHOD(setCoordinates:(double)lat lng:(double)lng)
{
  NSNumber *myDoubleNumber = [NSNumber numberWithDouble:lat];
  NSString *latitude = [myDoubleNumber stringValue];
  RCTLogInfo(latitude);
  [self._mapView setLocationPoint:[TMapPoint mapPointWithCoordinate:CLLocationCoordinate2DMake(lat, lng)]];
}

RCT_EXPORT_METHOD(setMarker:(UIImage *)markerImg markerName:(NSString *)markerName)
{
  TMapPoint* mapPoint = [self._mapView getCenterPoint];
  //TMapPoint* mapPoint = [[[TMapPoint alloc] initWithCoordinate:CLLocationCoordinate2DMake(37.566474, 126.985022)] autorelease];
  TMapMarkerItem* marker1 = [[TMapMarkerItem alloc] init];
  [marker1 setTMapPoint:mapPoint];
  [marker1 setIcon:markerImg anchorPoint:CGPointMake(0.5, 1.0)];
  [marker1 setCanShowCallout:YES];
  [marker1 setCalloutTitle:@"CallOut 타이틀"];
  [marker1 setCalloutSubtitle:@"CallOut 서브타이틀"];
  [marker1 setCalloutLeftImage:[UIImage imageNamed:@"end.png"]];
  [marker1 setCalloutRightButtonImage:[UIImage imageNamed:@"accessory_detail.png"]];
  [marker1 setName:[NSString stringWithFormat:markerName]];

  [marker1 setEnableClustering:YES];

  [self._mapView addTMapMarkerItemID:markerName Marker:marker1 animated:NO];
}

RCT_EXPORT_METHOD(search:(NSString *)searchValue)
{
  BOOL installed = [TMapTapi isTmapApplicationInstalled];
  NSLog(@"installed: %d", installed);
  [TMapTapi invokeSearchPortal:searchValue];
}

#pragma mark - TMapViewDelegate

- (void)mapview
{
  [TMapTapi invokeSetLocation:@"신도림역" coordinate:self._mapView.centerCoordinate];
}

- (void)route
{
    [TMapTapi invokeRoute:@"신도림역" coordinate:self._mapView.centerCoordinate];
}

- (void)onClick:(TMapPoint *)TMP
{
  [self._mapView setLocationPoint:TMP];
}

- (void)onLongClick:(TMapPoint*)TMP
{
  // CLLocationCoordinate2D centerCoord = {TMP.coordinate.latitude ,TMP.coordinate.longitude};
  // [self._mapView setCenterCoordinate:centerCoord];
}

- (void)GPS_ON
{
    if (__gps == nil) {
        __gps = [[TMapGpsManager alloc] init];
    }
    
    // 백그라운드 위치정보 얻기
    //[__gps setAlwaysAuthorization:YES];
    
    [__gps setDelegate:self];
    [__gps openGps];
    
}

- (void)GPS_OFF
{
    [__gps closeGps];
    
    __gps = nil;
}

#pragma mark - Map View

- (UIView *)view
{
  [self._mapView setAutoresizingMask:UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight];
  [self._mapView setDelegate:self];
  [self._mapView setGpsManagersDelegate:self];
  [self._mapView setSKTMapApiKey:@"l7xx9d4d587fe7104a57b8feda886c846d1f"];
  [TMapTapi invokeSetLocation:@"신도림역" coordinate:self._mapView.centerCoordinate];
  [TMapTapi setSKTMapAuthenticationWithDelegate:self apiKey:@"l7xx9d4d587fe7104a57b8feda886c846d1f"];
  return [self._mapView init];
}

@end
